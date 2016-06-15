<#include "head.ftl">

<!-- The drawer is always open in large screens. The header is always shown,
  even in small screens. -->
<div class="mdl-layout mdl-js-layout">
    <header class="mdl-layout__header">
        <div class="mdl-layout__header-row">
            <span class="mdl-layout-title">
                ${appName}
            </span>
            <div class="mdl-layout-spacer"></div>
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable
                  mdl-textfield--floating-label mdl-textfield--align-right">
                <label class="mdl-button mdl-js-button mdl-button--icon"
                       for="fixed-header-drawer-exp">
                    <i class="material-icons">search</i>
                </label>
                <div class="mdl-textfield__expandable-holder">
                    <input class="mdl-textfield__input" type="text" name="sample"
                           id="fixed-header-drawer-exp">
                </div>
            </div>
        </div>
    </header>
    <div class="">
        <span class="mdl-layout-title">
        Boards
        </span>

        <button id="demo-menu-lower-left"
                class="mdl-button mdl-js-button mdl-button--icon">
            <i class="material-icons">more_vert</i>
        </button>
        <ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect" for="demo-menu-lower-left">
            <li class="mdl-menu__item">Some Action</li>
            <li class="mdl-menu__item mdl-menu__item--full-bleed-divider">Another Action</li>
            <li disabled class="mdl-menu__item">Disabled Action</li>
            <li class="mdl-menu__item">Yet Another Action</li>
        </ul>
        <nav class="mdl-navigation">
        <#list boards as board>
            <a class="mdl-navigation__link" href="">${board.content}</a>
        </#list>
        </nav>
    </div>
    <main class="mdl-layout__content">
        <div class="page-content"><!-- Your content goes here --></div>
    </main>
</div>

<#include "tail.ftl">