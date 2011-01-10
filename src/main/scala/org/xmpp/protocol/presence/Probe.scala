package org.xmpp
{
	package protocol.presence
	{
		import scala.collection._
		import scala.xml._
		
		import org.xmpp.protocol._
		import org.xmpp.protocol.Protocol._
			
		object Probe
		{
			val stanzaType = PresenceTypeEnumeration.Probe
			val stanzaTypeName = stanzaType.toString // FIXME, this should be done automatically via implicit def, but does not work for enum values for some reson
			
			def apply(id:Option[String], to:Option[JID], from:Option[JID]):Probe =
			{					
				val xml = Presence.build(stanzaType, id, to, from, None, None, None, None)
				return apply(xml)
			}
			
			def apply(xml:Node):Probe = new Probe(xml)
		}
		
		class Probe(xml:Node) extends Presence(xml, Probe.stanzaType)
		{
		}
	}
}