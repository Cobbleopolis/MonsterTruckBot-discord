package com.cobble.bot.db

// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.PostgresProfile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = BotInstances.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table BotInstances
   *  @param guildId Database column guild_id SqlType(varchar), PrimaryKey, Length(256,true)
   *  @param moderatorRoleId Database column moderator_role_id SqlType(varchar), Length(256,true), Default(None) */
  final case class BotInstance(guildId: String, moderatorRoleId: Option[String] = None)
  /** GetResult implicit for fetching BotInstancesRow objects using plain SQL queries */
  implicit def GetResultBotInstancesRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[BotInstance] = GR{
    prs => import prs._
    BotInstance.tupled((<<[String], <<?[String]))
  }
  /** Table description of table bot_instances. Objects of this class serve as prototypes for rows in queries. */
  class BotInstances(_tableTag: Tag) extends profile.api.Table[BotInstance](_tableTag, "bot_instances") {
    def * = (guildId, moderatorRoleId) <> (BotInstance.tupled, BotInstance.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(guildId), moderatorRoleId).shaped.<>({r=>import r._; _1.map(_=> BotInstance.tupled((_1.get, _2)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column guild_id SqlType(varchar), PrimaryKey, Length(256,true) */
    val guildId: Rep[String] = column[String]("guild_id", O.PrimaryKey, O.Length(256,varying=true))
    /** Database column moderator_role_id SqlType(varchar), Length(256,true), Default(None) */
    val moderatorRoleId: Rep[Option[String]] = column[Option[String]]("moderator_role_id", O.Length(256,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table BotInstances */
  lazy val BotInstances = new TableQuery(tag => new BotInstances(tag))
}
