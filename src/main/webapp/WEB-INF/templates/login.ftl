<#import "/spring.ftl" as spring/>
<#import "master/master.ftl" as master/>
<@master.main title="Login">
<form action="${rc.getContextPath()}/login" method="POST">
    <@spring.bind "login.username"/>
    <label for="${spring.status.expression}">Nutzernamen</label>
    <input type="text" name="${spring.status.expression}"/>

    <@spring.bind "login.password"/>
    <label for="${spring.status.expression}">Passwort</label>
    <input type="password" name="${spring.status.expression}"/>

    <input type="submit" value="Login">
</form>
</@master.main>