<%@taglib prefix="tag" uri="http://www.impexformatter.com/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>

<tag:master>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h5>
				Please enter your <strong>Hybris Impex</strong> snippet
			</h5>
		</div>
		<div class="panel-body">
			<c:url var="action" value="/result"></c:url>
			<form:form method="POST" action="${action}">
				<div class="page-header">
					<h6>
						<strong>Macros</strong>
					</h6>
				</div>
				<form:textarea path="iMacros" cssClass="form-control"
					cssStyle="font-size: 12px;" rows="2" />
				<div class="page-header">
					<h6>
						<strong>Header</strong>
					</h6>
				</div>
				<form:textarea path="iHeader" cssClass="form-control"
					cssStyle="font-size: 12px;" rows="1" />
				<div class="page-header">
					<h6>
						<strong>Content</strong>
					</h6>
				</div>
				<form:textarea path="iContent" cssClass="form-control"
					cssStyle="font-size: 12px;" rows="5" />

				<br />

				<center>
					<div class="form-group">
						<button type="submit" class="btn btn-primary">Submit</button>
						&nbsp;
						<button type="reset" class="btn btn-default">Cancel</button>
					</div>
				</center>
			</form:form>

		</div>
	</div>
</tag:master>