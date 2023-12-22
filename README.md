# StatCounter
This plugin will let you create stats for players.

## Stats
Stats will have an identifier, a name, a description. Stats can also be categorised - so you can query the total stat count of multiple stats under a 'category' name.

## Data storage
Stats will be stored in an SQL database with a local cache to reduce queries. All updating of stats is immediately pushed to SQL. In the future, pushing to SQL could be configured to be periodic.

## Server support
The design of this plugin specifically caters to bungee/sponge/etc networks, hence the immediate pushing to SQL so that multiple server set-ups can be supported as long as the SQL database is the same across the servers.


## Roadmap
1. Create SQL interactions - push and pull to database
2. Ensure local cache works as intended (storing current stat values, reducing pull queries from database)
3. Create commands to set and query stats for players regardless of online/offline status
4. Create classes to map the ID of a stat to a name and description and any parent stats
5. Update commands to support stat names as well as identifiers
6. Add PlaceholderAPI integration
7. Add configurable language file to support multiple languages
8. Look into templating the `<Long, Double>` format of the stat maps
9. Create commands to increment/decrement the players
10. Create an API