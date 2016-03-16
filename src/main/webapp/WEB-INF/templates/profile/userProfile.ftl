<#import "/spring.ftl" as spring/>
<#import "../master/master.ftl" as master/>
<@master.main title="Profil">
    <h1>${user.username}</h1>

    <div id="newPost">
        <form method="post" action="${rc.getContextPath()}/profil/${userId}/addPost">
            <textarea name="posting"></textarea>
            <input type="submit" value="Posten"/>
        </form>
    </div>
    <div id="pinnwand">
        <#list pinnwall as posting>
            <p>${posting.text}</p>
        </#list>
    </div>
</@master.main>