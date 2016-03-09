<#macro main title>
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="UTF-8">
        <title>${title?html}</title>
    </head>

    <body>
        <#nested/>
    </body>
    </html>
</#macro>