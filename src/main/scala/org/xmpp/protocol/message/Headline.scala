package org.xmpp
{
	package protocol.message
	{
		import scala.collection._
		import scala.xml._
		
		import org.xmpp.protocol._
		import org.xmpp.protocol.Protocol._
		
		object Headline
		{
			val stanzaType = MessageTypeEnumeration.Headline
			val stanzaTypeName = stanzaType.toString // FIXME, this should be done automatically via implicit def, but does not work for enum values for some reson			
			
			def apply(to:Option[JID], from:Option[JID], body:Option[String]):Headline = apply(None, to, from, None, body, None, None)
			
			def apply(id:Option[String], to:Option[JID], from:Option[JID], body:Option[String]):Headline = apply(id, to, from, None, body, None, None)
				
			def apply(id:Option[String], to:Option[JID], from:Option[JID], subject:Option[String], body:Option[String]):Headline = apply(id, to, from, subject, body, None, None)
					
			def apply(id:Option[String], to:Option[JID], from:Option[JID], subject:Option[String], body:Option[String], thread:Option[String], extension:Option[Extension]):Headline =
			{
				val xml = Message.build(stanzaType, id, to, from, subject, body, thread, extension)
				return apply(xml)
			}
			
			def apply(xml:Node):Headline = new Headline(xml)
		}
		
		class Headline(xml:Node) extends Message(xml, Headline.stanzaType)
		{
		}
		
	}
}