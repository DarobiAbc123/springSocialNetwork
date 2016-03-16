<#import "/spring.ftl" as spring/>
<#import "master/master.ftl" as master/>
<@master.main title="Home">
    <a href="${rc.getContextPath()}/profil/${userId}">Zum Profil</a>
</@master.main>