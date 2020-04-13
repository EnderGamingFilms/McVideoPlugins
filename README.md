[![](https://img.shields.io/badge/Subscribe-on%20Youtube-red.svg?logo=youtube)](https://youtube.com/endergamingfilms)

## VoidStep
This plugin will delete every block from where you stand to the void. You can set it to delete the blocks right under the player or delete it as the player walks off of it. There are some issues with this plugin so please keep reading.

## Dependencies
[**CoreProtect**](https://www.spigotmc.org/resources/coreprotect.8631/) - This is used to log blocks placed by the player and it takes it a second to update the data. If you don't wait 1-2 seconds before standing on the block you just placed it will be removed.

## Commands
`/vs on [under/behind]` - This is how you start the plugin.

`/vs off` - This will stop deleting blocks around the player.

`/vs help` - Will show all commands & permissions for the plugin.

## Issues
1. There has always been this lighting update glitch with Minecraft and that will make your game stutter, pretty much no matter what. To fix this I used a texurepack called 32x Faithful and it ran smoothly. (Can't be fixed)
2. Once you turn this plugin on it will spam your in-game chat with messages. **To fix just de-op yourself.** These messages are the result of running a fill command to delete the blocks. Since it's run from console it cannot be disabled by game rules. (You might be able to disable it in the spigot.yml or paper.yml)
