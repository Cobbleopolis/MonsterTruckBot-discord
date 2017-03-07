# Monster Truck Bot
> Custom bot

Custom bot written for the Monster Truck Rally

## TODO
This list is in no particular order of priority

### General

- [ ] Command permissions
- [ ] Unit tests?
- [ ] Use cache ([EHCache](http://www.ehcache.org/)?) to cache database results
- [ ] Plugin setup
    - [ ] Automatic plugin registration
    - [x] Register commands
    - [ ] Register settings
    - [ ] Separate settings tables in database
        - [ ] Insert the user's setting row when the plugin is enabled
        - [ ] Run each table creation on plugin registration
- [ ] Rework config setup to use a key/value setup 
- [ ] Use resource markdown files for command help?

### Core Plugin

- [x] Ping command
- [x] Help command
- [x] SOS command 
    - Sends dm to all mods w/ person's name who asked for help. Allows people to anon call mods quickly.
- [ ] Config command
    - Setup so that it uses `<pluginName>.<settingName>` format
- [ ] Plugin command
    - [ ] Enable plugin
    - [ ] Disable plugin
    - [ ] List plugins

### Filter Plugin 
 
- [ ] Filters
    - [ ] Word Blacklist
    - [ ] Caps
    - [ ] Links
- [ ] Set threshold per filter
- [ ] Set warning count per filter

### Custom Command Plugin

- [ ] Add custom command
- [ ] Set custom command
- [ ] Delete custom command
- [ ] List custom commands
- [ ] Set command permissions per custom command

### Welcome Plugin

- [ ] Join message
    - [ ] Custom channel support
    - [ ] Custom message
- [ ] Leave message
    - [ ] Custom channel support
    - [ ] Custom message

### Twitch Specific

- [ ] Custom sub message (if possible)
- [ ] Custom resub message
- [ ] Sub count

## Copyright and license

Code and documentation copyright 2017 Cobbleopolis. Code released under [the MIT license](https://github.com/Cobbleopolis/RandomHaus/blob/master/LICENSE).