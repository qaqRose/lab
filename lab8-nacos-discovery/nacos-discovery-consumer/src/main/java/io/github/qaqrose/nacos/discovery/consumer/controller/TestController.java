package io.github.qaqrose.nacos.discovery.consumer.controller;

import com.alibaba.cloud.nacos.ribbon.NacosServer;
import io.github.qaqrose.nacos.discovery.consumer.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * @author: qiu
 * 2021/10/3
 */
@RestController
public class TestController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RestTemplate restTemplate1;

    @Autowired
    private EchoService echoService;

    @GetMapping("getNacosMetaData")
    public Map<String, String> getNacosMetaData() {
        RibbonLoadBalancerClient.RibbonServer ribbonServer =
                (RibbonLoadBalancerClient.RibbonServer) loadBalancerClient.choose("qaq-provider");

        NacosServer nacosServer = (NacosServer) ribbonServer.getServer();
        // 获取nacos配置的源信息
        Map<String, String> metadata = nacosServer.getMetadata();
        return metadata;
    }

    @GetMapping("test")
    public String hello(String name) {
        ServiceInstance serviceInstance = loadBalancerClient.choose("qaq-provider");

        URI uri = serviceInstance.getUri();
        String result = restTemplate.getForObject(uri + "/hello?name=" + name, String.class);

        return result;
    }


    @GetMapping("discoveryClientService")
    public Object getDiscoveryClientService() {
        return discoveryClient.getServices();
    }

    @GetMapping("getDiscoveryClient")
    public Object getDiscoveryClient() {
        List<ServiceInstance> instances = discoveryClient.getInstances("qaq-provider");
        return instances;
    }

    @GetMapping("/echo-rest/{str}")
    public String rest(@PathVariable String str) {
        return restTemplate.getForObject("http://qaq-provider/echo/" + str,
                String.class);
    }

    @GetMapping("/index")
    public String index() {
        return restTemplate1.getForObject("http://qaq-provider", String.class);
    }

//    @GetMapping("/test")
//    public String test() {
//        return restTemplate1.getForObject("http://qaq-provider/test", String.class);
//    }

    @GetMapping("/sleep")
    public String sleep() {
        return restTemplate1.getForObject("http://qaq-provider/sleep", String.class);
    }

    @GetMapping("/notFound-feign")
    public String notFound() {
        return echoService.notFound();
    }

    @GetMapping("/divide-feign")
    public String divide(@RequestParam Integer a, @RequestParam Integer b) {
        return echoService.divide(a, b);
    }

    @GetMapping("/divide-feign2")
    public String divide(@RequestParam Integer a) {
        return echoService.divide(a);
    }

    @GetMapping("/echo-feign/{str}")
    public String feign(@PathVariable String str) {
        return echoService.echo(str);
    }

    @GetMapping("/services/{service}")
    public Object client(@PathVariable String service) {
        return discoveryClient.getInstances(service);
    }

    @GetMapping("/services")
    public Object services() {
        return discoveryClient.getServices();
    }

}
