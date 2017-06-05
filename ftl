hashes
	scalars 
	sequence 


${...}: FreeMarker will replace it in the output with the actual value of the expression inside the curly brackets. They are called interpolations.



interpolations  ${..}
Ftl tags start with '#' and user defined tags start with '@'.



Directives:

	1) if Directive

		<#if message == "helloWorld">Hello WOrld</#if>

		message - reference variable.
		any variable or unquoted words inside directives or interpolation will be replaced by it's value.


		<#if condition>
		
		<#elseif condition>
		
		<#else>

		</#if>


	2) <#list sequence as variable> ${variable.param}<#/list>


	3) (expression to be evaludated)


	4) ?? -> You can ask whether a variable isn't missing by putting ?? after its name. 


User Defined directives using macro <#macro directiveName prameters..>
	
	user defined directive should be accessed by using '@'

		<#macro myDirective name>
			Hello ${name}
		<#/macro>
		<@mydirective name="srujan></@mydirective>


