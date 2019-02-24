import React, {Component} from "react";
import axios from "axios";

export default class Dashboard extends Component {
    constructor(props) {
        super(props);
        this.state = {
            documents: [
                {id: 1, title: 'М. Е. Вадимовна "Одно чудо на всю жизнь"', preview: 'Ого, такой вот вопросик. Прямо садись и рассказывай всю свою жизнь!<br/> Значит, во-первых (хронологически) — за то, что сообщили мне некоторую веру в себя. Когда ты начинающий, робкий новичок и тебе авторитетный, искушенный в своем деле мастер говорит, что у тебя получается — это создает неслыханной силы импульс. Во-вторых, за среду. Эльга Львовна вовсю приобщала нас к среде взрослых, профессиональных переводчиков, да и нас самих, неофитов, превращала в группу единомышленников, поглощенных общим делом и вообще литературой. В ее семинаре при Союзе писателей говорили ведь далеко не только о переводе.', date: '12 Фев. 2019 г.'},
                {id: 2, title: 'М. Булгаков "Мастер и Маргарита"', preview: 'Однажды весною, в час небывало жаркого заката, в Москве, на Патриарших прудах, появились два гражданина.<br/> Первый из них, одетый в летнюю серенькую пару, был маленького роста, упитан, лыс, свою приличную шляпу пирожком нес в руке, а на хорошо выбритом лице его помещались сверхъестественных размеров очки в черной роговой оправе', date: '4 Дек. 2018 г.'}
            ],
            title: 'Document 1'
        }
        this.toDocument = this.toDocument.bind(this)
    }

    componentDidMount() {
        // pull documents from backend
    }

    toDocument() {
        this.props.history.push("/document")
    }

    render() {
        return (
            <div className="container-fluid" id="tld-container-wrap">
                <div id="tl-header">
                    {this.state.title}
                </div>
                <div id="tld-container">
                    <div id="tld-list">
                        {this.state.documents.map((item, i) => {
                            return (
                                <div className="tld-doc float-left" key={i} onClick={this.toDocument}>
                                    <div className="tld-thumb">
                                        <div className="thumb-text" dangerouslySetInnerHTML={{__html: item.preview.trim()}} />
                                    </div>
                                    <div className="tld-doc-title" dangerouslySetInnerHTML={{__html: item.title.trim()}}/>
                                    <div className="tld-doc-date" dangerouslySetInnerHTML={{__html: item.date.trim()}}/>
                                </div>
                            )
                        })}
                    </div>
                </div>
            </div>
        )
    }
}