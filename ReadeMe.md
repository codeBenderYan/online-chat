1.项目使用Swagger作为项目的接口文档。  
2.项目使用了SpringSecurity作为项目的安全框架。
Spring Security 6.x 的认证实现流程如下：  
①用户提交登录请求
②Spring Security 将请求交给 UsernamePasswordAuthenticationFilter 过滤器处理。  
③UsernamePasswordAuthenticationFilter 获取请求中的用户名和密码，并生成一个 AuthenticationToken 对象，将其交给 AuthenticationManager 进行认证。  
④AuthenticationManager 通过 UserDetailsService 获取用户信息，然后使用 PasswordEncoder 对用户密码进行校验。  
⑤如果密码正确，AuthenticationManager 会生成一个认证通过的 Authentication 对象，并返回给 UsernamePasswordAuthenticationFilter 过滤器。如果密码不正确，则 AuthenticationManager 抛出一个 AuthenticationException 异常。  
⑥UsernamePasswordAuthenticationFilter 将 Authentication 对象交给 SecurityContextHolder 进行管理，并调用 AuthenticationSuccessHandler 处理认证成功的情况。  
⑦如果认证失败，UsernamePasswordAuthenticationFilter 会调用 AuthenticationFailureHandler 处理认证失败的情况。  

