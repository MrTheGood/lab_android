/*
 *    Copyright 2018 Maarten de Goede
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package eu.insertcode.architectureexperiment

import eu.insertcode.architectureexperiment.data.Article

/**
 * Created by maartendegoede on 18/06/2018.
 * Copyright © 2018 insertCode.eu. All rights reserved.
 */
object MockData {
    val articles = listOf(
            Article(0, "https://payload110.cargocollective.com/1/6/209189/4517674/LOREM-IPSUM3.jpg", "Lorem", "Lorem ipsum dolor sit amet"),
            Article(
                    1,
                    "https://d1hw6n3yxknhky.cloudfront.net/007730263_prevstill.jpeg",
                    "Android Architecture Components",
                    "I am currently working on trying out Android Architecture Components. So far I think it adds way too much Boilerplate, but we'll see how well it turns out."
            ),
            Article(
                    2,
                    "https://img00.deviantart.net/62dc/i/2015/364/a/b/how_many_seconds_in_eternity__by_zygonbonnie-d9m0oz3.jpg",
                    "How many seconds in eternity.",
                    """The shepperds boy said: "There is a mountain made of a material 400x stronger than diamond. It is one mile high, a mile wide and a mile deep. Every 100 years a little bird comes around and sharpens its beak on the mountain. When the entire mountain is chiseled away, the first second of eternity will have passed." You might say 'Thats helluva mountain', but personally I think its helluva bird. """
            ),
            Article(
                    3,
                    "https://proxy.duckduckgo.com/iu/?u=https%3A%2F%2Fmaster.usfine.biz%2Fupload%2Fuserfiles%2Fimages%2F306eb484305bc3649eda0130994d318f.jpg&f=1",
                    "Red Mountain.",
                    "It sleeps like a giant, our tower of stones, Red Mountain, Red Mountain, all rumbles and moans. It tosses and turns, pray it won't wake, And then without warning the ground starts to shake ! As the world ends, the ground starts to shake! So— /nHeft a flask and say a prayer, Red Mountain's about to explode. Have a drink but be aware, It's doom the mountain forebodes. \nLift a glass and curse the day, Red Mountain's about to burst. Drink all your cares away, Who wants to die with a thirst? Die with a thirst! \nKnock back a fiery flin, amid the smoke and ash. Drain the flask of whiskey we'll be drunk in a flash! Let's guzzle sujamma amid the fire and fumes Tip back the jar of liquor let inebriation bloom! As the world ends, let inebriation bloom! So— \nLift a glass and curse the day, Red Mountain's about to burst. Drink all your cares away, Who wants to die with a thirst? Die with a thirst!"
            ),
            Article(
                    4,
                    "https://i.ytimg.com/vi/KZ6As4eMxsI/maxresdefault.jpg",
                    "Nights Watch.",
                    "Night gathers and now my watch begins. It shall not end untill my death. I shall take no wives, hold no lands, father no children. I shall live and die at my post. I am the sword in the darkness. I am the watcher on the walls. I am the light in the darkness, the sword that brings the dawn, the horn that wakes the sleepers, the shield that guards the realms of men. I give my life and honor to the Nights Watch, for this night and all nights to come."
            ),
            Article(
                    5,
                    "https://68.media.tumblr.com/tumblr_ltslimC4UB1r5aaelo1_500.jpg",
                    "The One Ring To Rule Them All.",
                    "One ring to rule them all. One ring to find them. One ring to bring them all and in darkness bind them."
            ),
            Article(
                    6,
                    "https://proxy.duckduckgo.com/iur/?f=1&image_host=http%3A%2F%2Ffc09.deviantart.net%2Ffs70%2Fi%2F2013%2F158%2F8%2F2%2Flady_stoneheart_by_zippo514-d6850n3.jpg&u=http://img09.deviantart.net/2381/i/2013/158/8/2/lady_stoneheart_by_zippo514-d6850n3.jpg",
                    "Lady Stoneheart.",
                    "Her cloak and collar hid the gash his brother’s blade had made, but her face was even worse than he remembered. The flesh had gone pudding soft in the water and turned the color of curdled milk. Half her hair was gone and the rest had turned as white and brittle as a crone’s. Beneath her ravaged scalp, her face was shredded skin and black blood where she had raked herself with her nails. But her eyes were the most terrible thing. Her eyes saw him, and they hated."
            ),
            Article(
                    7,
                    "https://media.moddb.com/images/games/1/14/13863/War.jpg",
                    "Age of agression.",
                    "We drink to our youth, to days come and gone. For the age of aggression is just about done. We'll drive out the Stormcloaks and restore what we own. With our blood and our steel we will take back our home. Down with Ulfric! The killer of kings! On the day of your death we will drink and we'll sing. We're the children of Skyrim, and we fight all our lives. And when Sovngarde beckons, every one of us dies! But this land is ours and we'll see it wiped clean. Of the scourge that has sullied our hopes and our dreams! Down with Ulfric! The killer of kings! On the day of your death we will drink and we'll sing. We're the children of Skyrim, and we fight all our lives. And when Sovngarde beckons, every one of us dies! We drink to our youth, to the days come and gone. For the age of aggression is just about done."
            )
    )
}