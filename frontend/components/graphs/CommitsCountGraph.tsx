import React, { PureComponent, useEffect, useState } from 'react';
import axios, {AxiosResponse} from "axios";
import {
  BarChart,
  Bar,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  Legend,
  ResponsiveContainer,
} from "recharts";
import {useRouter} from "next/router";
import {AuthContext} from "../../components/AuthContext";
import AuthView from "../../components/AuthView";
import {useSnackbar} from "notistack";

const data = [
    { date: "Jan 10", commits: 0},
    { date: "Feb 12", commits: 14},
    { date: "Feb 13", commits: 10},
    { date: "Feb 14", commits: 0},
    { date: "Feb 15", commits: 15},
    { date: "Feb 16", commits: 23},
    { date: "Feb 17", commits: 34},
    { date: "Feb 18", commits: 0},
    { date: "Feb 19", commits: 0},
    { date: "Feb 20", commits: 0},
    { date: "Feb 21", commits: 14},
    { date: "Feb 22", commits: 12},
    { date: "Feb 23", commits: 25},
    { date: "Feb 24", commits: 16},
];

class Chart extends React.Component {
    render() {
        return (
            <ResponsiveContainer width="100%" height={400} minWidth="0">
                <BarChart
                    width={900}
                    height={350}
                    data={data}
                    margin={{ top: 8, right: 30, left: 20, bottom: 10 }}
                >
                    <CartesianGrid strokeDasharray="3 3" />
                    <XAxis dataKey="date" label={{ value: "Date", position: "middle", dy: 10}} />
                    <YAxis label={{ value: 'Total Count', angle: -90, position: 'insideLeft' }} />
                    <Tooltip />
                    <Bar dataKey="commits" fill="#82ca9d" barSize={15} />
                </BarChart>
            </ResponsiveContainer>
        );
    }
}

export default Chart;