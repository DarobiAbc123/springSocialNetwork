<#import "/spring.ftl" as spring/>
<#import "master/master.ftl" as master/>
<@master.main title="Registrieren">
<form action="${rc.getContextPath()}/register" method="POST">
    <@spring.bind "register.username"/>
    <label for="${spring.status.expression}">Nutzernamen</label>
    <input type="text" name="${spring.status.expression}"/>

    <@spring.bind "register.email"/>
    <label for="${spring.status.expression}">E-Mail</label>
    <input type="text" name="${spring.status.expression}"/>

    <@spring.bind "register.password"/>
    <label for="${spring.status.expression}">Passwort</label>
    <input type="password" name="${spring.status.expression}"/>

    <@spring.bind "register.passwordRepeat"/>
    <label for="${spring.status.expression}">Passwort wiederholen</label>
    <input type="password" name="${spring.status.expression}"/>

    <input type="submit" value="Registrieren">
</form>
</@master.main>