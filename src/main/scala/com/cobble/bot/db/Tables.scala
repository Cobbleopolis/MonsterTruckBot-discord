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
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = BotInstances.schema ++ CoreSettings.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table BotInstances
   *  @param guildId Database column guild_id SqlType(varchar), PrimaryKey, Length(256,true)
   *  @param twitchAccount Database column twitch_account SqlType(varchar), Length(25,true), Default(None) */
  final case class BotInstancesRow(guildId: String, twitchAccount: Option[String] = None)
  /** GetResult implicit for fetching BotInstancesRow objects using plain SQL queries */
  implicit def GetResultBotInstancesRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[BotInstancesRow] = GR{
    prs => import prs._
    BotInstancesRow.tupled((<<[String], <<?[String]))
  }
  /** Table description of table bot_instances. Objects of this class serve as prototypes for rows in queries. */
  class BotInstances(_tableTag: Tag) extends profile.api.Table[BotInstancesRow](_tableTag, "bot_instances") {
    def * = (guildId, twitchAccount) <> (BotInstancesRow.tupled, BotInstancesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(guildId), twitchAccount).shaped.<>({r=>import r._; _1.map(_=> BotInstancesRow.tupled((_1.get, _2)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column guild_id SqlType(varchar), PrimaryKey, Length(256,true) */
    val guildId: Rep[String] = column[String]("guild_id", O.PrimaryKey, O.Length(256,varying=true))
    /** Database column twitch_account SqlType(varchar), Length(25,true), Default(None) */
    val twitchAccount: Rep[Option[String]] = column[Option[String]]("twitch_account", O.Length(25,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table BotInstances */
  lazy val BotInstances = new TableQuery(tag => new BotInstances(tag))

  /** Entity class storing rows of table CoreSettings
   *  @param guildId Database column guild_id SqlType(varchar), PrimaryKey, Length(256,true)
   *  @param moderatorRoleId Database column moderator_role_id SqlType(varchar), Length(256,true), Default(None) */
  final case class CoreSettingsRow(guildId: String, moderatorRoleId: Option[String] = None)
  /** GetResult implicit for fetching CoreSettingsRow objects using plain SQL queries */
  implicit def GetResultCoreSettingsRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[CoreSettingsRow] = GR{
    prs => import prs._
    CoreSettingsRow.tupled((<<[String], <<?[String]))
  }
  /** Table description of table core_settings. Objects of this class serve as prototypes for rows in queries. */
  class CoreSettings(_tableTag: Tag) extends profile.api.Table[CoreSettingsRow](_tableTag, "core_settings") {
    def * = (guildId, moderatorRoleId) <> (CoreSettingsRow.tupled, CoreSettingsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(guildId), moderatorRoleId).shaped.<>({r=>import r._; _1.map(_=> CoreSettingsRow.tupled((_1.get, _2)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column guild_id SqlType(varchar), PrimaryKey, Length(256,true) */
    val guildId: Rep[String] = column[String]("guild_id", O.PrimaryKey, O.Length(256,varying=true))
    /** Database column moderator_role_id SqlType(varchar), Length(256,true), Default(None) */
    val moderatorRoleId: Rep[Option[String]] = column[Option[String]]("moderator_role_id", O.Length(256,varying=true), O.Default(None))

    /** Foreign key referencing BotInstances (database name core_settings_bot_instances_guild_id_fk) */
    lazy val botInstancesFk = foreignKey("core_settings_bot_instances_guild_id_fk", guildId, BotInstances)(r => r.guildId, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table CoreSettings */
  lazy val CoreSettings = new TableQuery(tag => new CoreSettings(tag))
}
