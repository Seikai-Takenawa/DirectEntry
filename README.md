#信息|Information
----------------
此模组的核心功能为：跳过在某些情况下，进入或创建新的世界时，总会弹出的“实验性警告”屏幕。<br />
The core function of this mod is to skip the "Experimental Warning" screen that <br />
always pops up when entering or creating a new world in certain situations.

此部分代码为本人学习开发我的世界1.21.1Forge端模组过程中，遇到：进入世界时总会弹出实验性警告窗口而<br />
研究开发的，源代码原集成于个人学习实验项目PoopPioneer，[详见](https://github.com/Seikai-Takenawa/pooppioneer)<br />
This part of the code was developed during my process of learning to create Minecraft 1.21.1 Forge mods, <br />
specifically to address the issue of the experimental warning screen always appearing when entering a world. <br />
The original source code was integrated into my personal learning and experimental project PoopPioneer.[More Information](https://github.com/Seikai-Takenawa/pooppioneer)

此部分代码的核心原理为：<br />
通过Mixin注入WorldOpenFlows.class中的forceLoadWorld()方法，使其跳过所有判断，直接执行loadWorld.run()方法。<br />
同时，通过Mixin注入，模组也**强制**将“世界是否为旧版本”定义为false，“游戏周期的稳定性”定义为true。<br />
The core principle of this part of the code is:<br />
By injecting the forceLoadWorld() method in WorldOpenFlows.class through Mixin, it skips all checks and directly executes the loadWorld.run() method.<br />
At the same time, through Mixin injection, the mod also **forcibly** sets "whether the world is an old version" to false and "the stability of the lifecycle" to true.

#效果|Demonstration
-------------------
![before](https://github.com/Seikai-Takenawa/DirectEntry/blob/master/example.before.gif)
![after](https://github.com/Seikai-Takenawa/DirectEntry/blob/master/example.after.gif)

#警告|Warnning
---------------
模组实现跳过“实验性警告”的过程可以说是**强制且暴力的**，由于在创建和加载世界的过程中**不会进行任何检查**，请在加入本模组前<br />
**慎重考虑！**<br />
The module's method of bypassing the 'experimental warning' can be described as **forcible and aggressive**. <br />
Since **no checks are performed** during the creation and loading of the world, please **consider carefully** before installing this mod!
