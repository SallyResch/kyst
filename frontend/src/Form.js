import React, { Component } from 'react'
import PropTypes from 'prop-types'
import Input from './Input'

class Form extends Component {

    constructor(props) {
        super(props)
        if(props.error) {
            this.state = {
                failure: 'wrong username or password!',
                errorcount: 0
            }
        } else {
            this.state = { errorcount: 0 }
        }
    }

    handleError = (field, errormsg) => {
        if(!field) return

        if(errormsg) {
            this.setState((prevState) => ({
                failure: '',
                errorcount: prevState.errorcount + 1,
                errormsgs: {...prevState.errormsgs, [field]: errormsg}
            }))
        } else {
            this.setState((prevState) => ({
                failure: '',
                errorcount: prevState.errorcount===1? 0 : prevState.errorcount-1,
                errormsgs: {...prevState.errormsgs, [field]: ''}
            }))
        }
    }
    handleSubmit = (event) => {
        event.preventDefault()
        if(!this.state.errorcount) {
            const data = new FormData(this.form)
            fetch(this.form.action, {
                method: this.form.method,
                body: new URLSearchParams(data)
            })
                .then(v => {
                    if(v.redirected) window.location = v.url
                })
                .catch(e => console.warn(e))
        }
    }

    renderError = () => {
        if(this.state.errorcount || this.state.failure) {
            const errormsg = this.state.failure
                || Object.values(this.state.errormsgs).find(v=>v)
            return <div className="error">{errormsg}</div>
        }
    }


    render() {
        const inputs = this.props.inputs.map(
            ({name, placeholder, type, value, className}, index) => (
                <Input key={index} name={name} placeholder={placeholder} type={type} value={value}
                       className={type==='submit'? className : ''} handleError={this.handleError} />
            )
        )
        const errors = this.renderError()
        return (
            <form {...this.props} onSubmit={this.handleSubmit} ref={fm => {this.form=fm}} >
                {inputs}
                {errors}
            </form>
        )
    }
}

Form.propTypes = {
    name: PropTypes.string,
    action: PropTypes.string,
    method: PropTypes.string,
    inputs: PropTypes.array,
    error: PropTypes.string
}



export default Form