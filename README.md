# Monster Truck Bot
> Custom bot

Custom bot written for the Monster Truck Rally

## TODO
This list is in no particular order of priority

- [x] Help command
- [ ] Command permissions 
- [ ] Chat Moderation
    - [ ] Word Blacklist
    - [ ] Caps
    - [ ] Links
- [ ] Add commands (alias setup)?
    - [ ] Add alias
    - [ ] Set alias
    - [ ] Delete alias
    - [ ] List aliases
- [ ] Unit tests?
- [x] SOS command 
    - Sends dm to all mods w/ person's name who asked for help. Allows people to anon call mods quickly.
- [ ] Use cache ([EHCache](http://www.ehcache.org/)?) to cache database results
- [ ] Join message
    - [ ] Custom channel support
    - [ ] Custom message
- [ ] Leave message
    - [ ] Custom channel support
    - [ ] Custom message 
- [x] Plugin setup
    - [ ] Automatic plugin registration
    - [x] Register commands
    - [ ] Register settings
    - [ ] Separate settings tables in database
        - [ ] Insert the user's setting row when the plugin is enabled
        - [ ] Run each table creation on plugin registration
- [ ] Rework config setup to use a key/value setup 
- [ ] Use a separate table in the database for each plugin
- [ ] Use resource markdown files for command help?

### Twitch Specific

- [ ] Custom sub message (if possible)
- [ ] Custom resub message
- [ ] Sub count

## Copyright and license

Code and documentation copyright 2017 Cobbleopolis. Code released under [the MIT license](https://github.com/Cobbleopolis/RandomHaus/blob/master/LICENSE).