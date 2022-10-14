<html>
<head>
    <%-- If this meta tag isn't provided, grails will try to find a layout file called views/layouts/quote.gsp --%>
    <%-- <meta name="layout" content="main" /> --%>
    <title>Random Quote</title>
    <asset:stylesheet src="snazzy.css"/>
    <g:javascript library="jquery" />
</head>
<body>
    <ul id="menu">
        <%-- <li>
            <g:remoteLink action="ajaxRandom" update="quote">
                Next Quote
            </g:remoteLink>
        </li> --%>

        <li>
            <g:link action="index">
                Admin
            </g:link>
        </li>
    </ul>
    <div>
        <q>${quote.content}</q>
        <p><span class="snazzy">${quote.author}</span></p>
        <p><g:emoticon happy="false"></g:emoticon></p>

        <g:repeat times="3" var="j">
            <p>Repeat this 3 times! Current repeat = ${j}</p>
        </g:repeat>
    </div>
</body>
</html>