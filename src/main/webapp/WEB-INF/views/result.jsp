<%@taglib prefix="tag" uri="http://www.impexformatter.com/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>

<tag:master>
	<div class="panel-heading">
		<h5>Please type/paste your Hybris Impex Snippet</h5>
	</div>
	<div class="panel-body">
		${iMacro}
		
		${iHeader}
		
		${iContent}
	</div>
</tag:master>