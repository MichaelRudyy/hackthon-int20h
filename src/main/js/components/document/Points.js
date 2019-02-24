import React, {Component} from "react";

export default class Points extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        const ns = new Array(5);
        const nsRender = ns.fill(0, 0, 5).map((v, i) => {
             let completed = i < this.props.stage ? 'completed' : '';
             return (
                 <div className="tl-step-point-wrap d-table-cell" key={i}><div className={"tl-step-point " + completed}/></div>
             );
        });
        return (
            <nav id="tl-steps" className="d-table">
                <div id="tl-steps-points" className="d-table-row">
                    {nsRender}
                    <div className="d-table-cell">
                        <div className="tl-finish-button" onClick={this.props.onNextStage}>Next &raquo;</div>
                    </div>
                </div>
            </nav>
        )
    }
}