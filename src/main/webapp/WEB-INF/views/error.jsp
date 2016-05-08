<%@taglib prefix="tag" uri="http://www.impexformatter.com/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>

<tag:master>
	<div class="panel panel-danger">
		<div class="panel-heading">
			<h4 class="panel-title">An error has occured</h4>
		</div>
		<div class="panel-body">
			Impex Formatter was unable to process your Hybris Impex snippet. This could be caused by the following:
			<ul class="margin-top-20">
				<li>Invalid Hybris Impex syntax</li>
				<li>bla bla</li>
				<li>bla bla</li>
				<li>bla bla</li>
			</ul>
		</div>
	</div>
</tag:master>