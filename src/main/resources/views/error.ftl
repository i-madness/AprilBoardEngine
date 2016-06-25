<#include "head.ftl">

<style>
    .demo-card-wide > .mdl-card__title {
        top: 10%;
        color: #fff;
        height: 132px;
        background: url('/static/img/error-page-pic.gif') repeat-x;
    }
    .demo-card-wide > .mdl-card__title-text {
        color: #fff;
    }
</style>
</head>

<body>
<div class="mdl-cell--10-col mdl-cell--1-offset demo-card-wide mdl-card mdl-shadow--2dp">
    <div class="mdl-card__title">
        <h2 class="mdl-card__title-text">${errorName}</h2>
    </div>
    <div class="mdl-card__supporting-text">
        <p>О ужос! Похоже, что-то пошло не так!</p>
        <p>${errorMessage}</p>
    </div>
    <div class="mdl-card__actions mdl-card--border">
        <a onclick="history.back()" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
            Вернуться назад
        </a>
    </div>
</div>

<#include "tail.ftl">