<#include "head.ftl">

<!-- The drawer is always open in large screens. The header is always shown,
  even in small screens. -->
<div class="mdl-layout mdl-js-layout mdl-layout--fixed-drawer
            mdl-layout--fixed-header">
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
    <div class="mdl-layout__drawer">
        <span class="mdl-layout-title">Boards</span>
        <nav class="mdl-navigation">
        <#list boards as board>
            <a class="mdl-navigation__link" href="">${board.name}</a>
        </#list>
        </nav>
    </div>
    <main class="mdl-layout__content">
        <div class="page-content"><!-- Your content goes here --></div>
    </main>
</div>

<#include "tail.ftl">