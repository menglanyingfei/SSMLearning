package com.wtu.spring.base;

public class TestSpringIOC {

    public static void main(String[] args) throws Exception {
        SpringIOC springIOC = new SpringIOC("src/com/wtu/spring/base/spring.xml");
        Boy boy = (Boy) springIOC.getBean("boyId");
        System.out.println(boy);

        Girl girl = (Girl) springIOC.getBean("girlId");
        System.out.println(girl);

        Girl girl2 = new Girl();
        System.out.println(girl2);
    }
}
