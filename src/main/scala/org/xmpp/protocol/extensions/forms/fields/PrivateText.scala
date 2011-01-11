package org.xmpp
{
	package protocol.extensions.forms.fields
	{
		import scala.collection._
		import scala.xml._
		
		import org.xmpp.protocol._
		
		import org.xmpp.protocol.Protocol._
		
		object PrivateText
		{		
			val fieldType = FieldTypeEnumeration.PrivateText
			val fieldTypeName = fieldType.toString
			
			def apply(identifier:Option[String]=None, label:Option[String]=None, description:Option[String]=None, required:Boolean=false, children:Option[Seq[Node]]=None):PrivateText =
			{
				val xml = Field.build(PrivateText.fieldType, identifier, label, description, required, children)
				return apply(xml)
			}
			
			def apply(xml:Node):PrivateText = new PrivateText(xml)
		}
		
		class PrivateText(xml:Node) extends Field(xml, PrivateText.fieldType)
		{
		}
		
	}
}