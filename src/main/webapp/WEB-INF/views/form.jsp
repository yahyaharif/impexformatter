<%@taglib prefix="tag" uri="http://www.impexformatter.com/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>

<tag:master>
	<div class="panel-heading">
		<h5>Please type/paste your Hybris Impex Snippet</h5>
	</div>
	<div class="panel-body">
		<c:url var="action" value="/result"></c:url>
		<form:form method="POST" action="${action}">
			<div class="page-header">
				<h6>Macros</h6>
			</div>
			<div class="well">
				<form:textarea path="iMacros" cssClass="form-control" rows="2" />
			</div>
			<div class="page-header">
				<h6>Header</h6>
			</div>
			<div class="well">
				<form:textarea path="iHeader" cssClass="form-control" rows="1" />
			</div>
			<div class="page-header">
				<h6>Content</h6>
			</div>
			<div class="well">
				<form:textarea path="iContent" cssClass="form-control" rows="5" />
			</div>

			<br />

			<center>
				<div class="form-group">
					<button type="submit" class="btn btn-lg btn-primary">Submit</button>
					&nbsp;
					<button type="reset" class="btn btn-lg btn-default">Cancel</button>
				</div>
			</center>
		</form:form>

	</div>
</tag:master>